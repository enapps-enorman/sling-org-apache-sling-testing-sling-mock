/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.testing.mock.sling.junit5;

import static org.junit.Assert.assertNull;

import org.apache.sling.testing.mock.sling.context.modelsautoreg.ClasspathRegisteredModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Test with {@link SlingContext} which uses by default
 * {@link ResourceResolverMockSlingContext}.
 */
@ExtendWith(SlingContextExtension.class)
class NoSlingModelsRegistrationTest {

    private final SlingContext context = new SlingContextBuilder()
            .registerSlingModelsFromClassPath(false)
            .build();

    @Test
    public void testSlingModelClasspathRegistered() {
        context.request().setAttribute("prop1", "myValue");
        ClasspathRegisteredModel model = context.request().adaptTo(ClasspathRegisteredModel.class);
        // expect null because ClasspathRegisteredModel should not be registered
        // automatically from classpath
        assertNull(model);
    }

}
