/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tomcat.jdbc.test;

import org.junit.Assert;
import org.junit.Test;

import javax.sql.PooledConnection;
import java.sql.Connection;

public class TestGetConnection extends DefaultTestCase {

    @Test
    public void testGetConnection() throws Exception {
        Connection con = this.datasource.getConnection();
        Assert.assertTrue("Connection should implement javax.sql.PooledConnection",con instanceof PooledConnection);
        Connection actual = ((PooledConnection)con).getConnection();
        Assert.assertNotNull("Connection delegate should not be null.",actual);
        System.out.println("Actual connection:"+actual.getClass().getName());
    }
}
