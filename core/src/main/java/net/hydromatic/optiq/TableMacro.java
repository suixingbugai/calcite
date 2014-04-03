/*
// Licensed to Julian Hyde under one or more contributor license
// agreements. See the NOTICE file distributed with this work for
// additional information regarding copyright ownership.
//
// Julian Hyde licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except in
// compliance with the License. You may obtain a copy of the License at:
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
*/
package net.hydromatic.optiq;

import org.eigenbase.reltype.RelDataType;
import org.eigenbase.reltype.RelDataTypeFactory;

import java.util.List;

/**
 * Function that returns a {@link Table}.
 *
 * <p>As the name "macro" implies, this is invoked at "compile time", that is,
 * during query preparation. Compile-time expansion of table expressions allows
 * for some very powerful query-optimizations.</p>
 */
public interface TableMacro extends Function {
  /**
   * Returns the record type of the table yielded by this function when
   * applied to parameters of given types.
   *
   * @param typeFactory Type factory
   */
  RelDataType getRowType(RelDataTypeFactory typeFactory);

  /**
   * Applies arguments to yield a table.
   *
   * @param arguments Arguments
   * @return Table
   */
  Table apply(List<Object> arguments);
}

// End TableMacro.java