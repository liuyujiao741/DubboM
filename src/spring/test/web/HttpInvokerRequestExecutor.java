package spring.test.web;

/*
* Copyright 2002-2005 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
import java.io.IOException;
import spring.test.RemoteInvocation;
import spring.test.RemoteInvocationResult;
/**
* Strategy interface for actual execution of an HTTP invoker request.
* Used by HttpInvokerClientInterceptor and its subclass
* HttpInvokerProxyFactoryBean.
*
* <p>Two implementations are provided out of the box:
* <ul>
* <li><b>SimpleHttpInvokerRequestExecutor:</b>
* Uses J2SE facilities to execute POST requests, without support
* for HTTP authentication or advanced configuration options.
* <li><b>CommonsHttpInvokerRequestExecutor:</b>
* Uses Jakarta's Commons HttpClient to execute POST requests,
* allowing to use a preconfigured HttpClient instance
* (potentially with authentication, HTTP connection pooling, etc).
* </ul>
*
* @author Juergen Hoeller
* @since 1.1
* @see HttpInvokerClientInterceptor#setHttpInvokerRequestExecutor
*/
public interface HttpInvokerRequestExecutor {
/**
* Execute a request to send the given remote invocation.
* @param config the HTTP invoker configuration that specifies the
* target service
* @param invocation the RemoteInvocation to execute
* @return the RemoteInvocationResult object
* @throws IOException if thrown by I/O operations
* @throws ClassNotFoundException if thrown during deserialization
* @throws Exception in case of general errors
*/
RemoteInvocationResult executeRequest(HttpInvokerClientConfiguration config, RemoteInvocation invocation)
throws Exception;
}
