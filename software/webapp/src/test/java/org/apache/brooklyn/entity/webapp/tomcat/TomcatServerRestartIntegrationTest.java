/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.brooklyn.entity.webapp.tomcat;

import org.apache.brooklyn.api.entity.proxying.EntitySpec;
import org.apache.brooklyn.entity.webapp.tomcat.TomcatServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import brooklyn.entity.basic.AbstractSoftwareProcessRestartIntegrationTest;
import brooklyn.entity.basic.SoftwareProcess;

/**
 * Tests restart of the software *process* (as opposed to the VM).
 */
@Test(groups="Integration")
public class TomcatServerRestartIntegrationTest extends AbstractSoftwareProcessRestartIntegrationTest {
    
    // TODO Remove duplication from MySqlRestartIntegrationTest
    
    @SuppressWarnings("unused")
    private static final Logger LOG = LoggerFactory.getLogger(TomcatServerRestartIntegrationTest.class);

    @Override
    protected EntitySpec<? extends SoftwareProcess> newEntitySpec() {
        return EntitySpec.create(TomcatServer.class);
    }
}
