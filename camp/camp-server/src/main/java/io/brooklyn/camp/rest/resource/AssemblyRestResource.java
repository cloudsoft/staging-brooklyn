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
package io.brooklyn.camp.rest.resource;

import io.brooklyn.camp.dto.AssemblyDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.brooklyn.rest.apidoc.Apidoc;

import com.wordnik.swagger.core.ApiOperation;
import com.wordnik.swagger.core.ApiParam;

@Path(AssemblyRestResource.URI_PATH)
@Apidoc("Assembly resources")
@Produces("application/json")
public class AssemblyRestResource extends AbstractCampRestResource {

//    private static final Logger log = LoggerFactory.getLogger(AssemblyRestResource.class);
    
    public static final String URI_PATH = PlatformRestResource.CAMP_URI_PATH + "/assemblies";

    @Path("/{id}")
    @ApiOperation(value = "Get a specific assembly",
            responseClass = AssemblyDto.CLASS_NAME)
    @GET
    public AssemblyDto get(
            @ApiParam(value = "ID of item being retrieved", required = true)
            @PathParam("id") String id) {
        return dto().adapt(lookup(camp().assemblies(), id));
    }

}
