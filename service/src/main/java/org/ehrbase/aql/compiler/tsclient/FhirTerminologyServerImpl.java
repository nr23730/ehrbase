/*
 * Copyright (c) 2020 Vitasystems GmbH, Hannover Medical School, and Luis Marco-Ruiz (Hannover Medical School).
 *
 * This file is part of project EHRbase
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
package org.ehrbase.aql.compiler.tsclient;

import com.jayway.jsonpath.JsonPath;
import org.springframework.web.client.RestTemplate;

import java.util.List;
/***
 *@Created by Luis Marco-Ruiz on Feb 12, 2020
 */
public class FhirTerminologyServerImpl  implements TerminologyServer<String, String>{

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List expand(String valueSetId) {
		String response = restTemplate.getForObject(valueSetId, String.class);
		return JsonPath
				.parse(response)
				.read("$.expansion.contains.*.code", List.class);
	}

	@Override
	public Boolean validate(String concept, String valueSetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubsumptionResult subsumes(String conceptA, String conceptB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String lookUp(String conceptId) {
		// TODO Auto-generated method stub
		return null;
	}

}
