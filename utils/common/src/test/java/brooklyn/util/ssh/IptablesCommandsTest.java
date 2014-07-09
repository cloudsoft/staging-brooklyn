package brooklyn.util.ssh;

import org.testng.Assert;
import org.testng.annotations.Test;

import brooklyn.util.ssh.IptablesCommands.Chain;
import brooklyn.util.ssh.IptablesCommands.Policy;
import brooklyn.util.ssh.IptablesCommands.Protocol;

public class IptablesCommandsTest {

   private static final String cleanUptptablesRules = "( if test \"$UID\" -eq 0; then ( /sbin/iptables -F ); else sudo -E -n -S -- /sbin/iptables -F; fi )";

   public static final String insertIptablesRule = "( if test \"$UID\" -eq 0; then ( /sbin/iptables -I INPUT -i eth0 -p tcp --dport 3306 -j ACCEPT ); "
         + "else sudo -E -n -S -- /sbin/iptables -I INPUT -i eth0 -p tcp --dport 3306 -j ACCEPT; fi )";
   public static final String appendIptablesRule = "( if test \"$UID\" -eq 0; then ( /sbin/iptables -A INPUT -i eth0 -p tcp --dport 3306 -j ACCEPT ); "
         + "else sudo -E -n -S -- /sbin/iptables -A INPUT -i eth0 -p tcp --dport 3306 -j ACCEPT; fi )";
   public static final String insertIptablesRuleAll = "( if test \"$UID\" -eq 0; then ( /sbin/iptables -I INPUT -p tcp --dport 3306 -j ACCEPT ); "
         + "else sudo -E -n -S -- /sbin/iptables -I INPUT -p tcp --dport 3306 -j ACCEPT; fi )";
   public static final String appendIptablesRuleAll = "( if test \"$UID\" -eq 0; then ( /sbin/iptables -A INPUT -p tcp --dport 3306 -j ACCEPT ); "
         + "else sudo -E -n -S -- /sbin/iptables -A INPUT -p tcp --dport 3306 -j ACCEPT; fi )";
   
   @Test
   public void testCleanUpIptablesRules() {
      Assert.assertEquals(IptablesCommands.cleanUpIptablesRules(), cleanUptptablesRules);
   }

   @Test
   public void testInsertIptablesRules() {
      Assert.assertEquals(IptablesCommands.insertIptablesRule(Chain.INPUT, "eth0", Protocol.TCP, 3306, Policy.ACCEPT),
            insertIptablesRule);
   }

   @Test
   public void testAppendIptablesRules() {
      Assert.assertEquals(IptablesCommands.appendIptablesRule(Chain.INPUT, "eth0", Protocol.TCP, 3306, Policy.ACCEPT),
            appendIptablesRule);
   }
   
   @Test
   public void testInsertIptablesRulesForAllInterfaces() {
      Assert.assertEquals(IptablesCommands.insertIptablesRule(Chain.INPUT, Protocol.TCP, 3306, Policy.ACCEPT),
            insertIptablesRuleAll);
   }

   @Test
   public void testAppendIptablesRulesForAllInterfaces() {
      Assert.assertEquals(IptablesCommands.appendIptablesRule(Chain.INPUT, Protocol.TCP, 3306, Policy.ACCEPT),
            appendIptablesRuleAll);
   }
}
