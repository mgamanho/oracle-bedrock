/*
 * File: ContainerBasedPlatformTest.java
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * The contents of this file are subject to the terms and conditions of 
 * the Common Development and Distribution License 1.0 (the "License").
 *
 * You may not use this file except in compliance with the License.
 *
 * You can obtain a copy of the License by consulting the LICENSE.txt file
 * distributed with this file, or by consulting https://oss.oracle.com/licenses/CDDL
 *
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file LICENSE.txt.
 *
 * MODIFICATIONS:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 */

package com.oracle.tools.runtime.java;

import com.oracle.tools.runtime.ApplicationBuilder;
import com.oracle.tools.runtime.Platform;
import com.oracle.tools.runtime.SimpleApplication;
import com.oracle.tools.runtime.network.Constants;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

/**
 * Unit tests for {@link JavaVirtualMachine}s.
 * <p>
 * Copyright (c) 2014. All Rights Reserved. Oracle Corporation.<br>
 * Oracle is a registered trademark of Oracle Corporation and/or its affiliates.
 *
 * @author Jonathan Knight
 * @author Brian Oliver
 */
public class JavaVirtualMachineTest
{
    @Test
    public void shouldReturnHostName() throws Exception
    {
        Platform platform = JavaVirtualMachine.INSTANCE;

        assertThat(platform.getHostname(), is(Constants.getLocalHost()));
    }

    @Test
    public void shouldReturnJavaApplicationBuilder()
    {
        Platform           platform = new JavaVirtualMachine();

        ApplicationBuilder builder  = platform.getApplicationBuilder(JavaApplication.class);

        assertThat(builder, instanceOf(ContainerBasedJavaApplicationBuilder.class));
    }


    @Test
    public void shouldReturnLocalApplicationBuilder()
    {
        Platform           platform = new JavaVirtualMachine();

        ApplicationBuilder builder  = platform.getApplicationBuilder(SimpleApplication.class);

        assertThat(builder, is(nullValue()));
    }
}
