package com.sb.rest.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sb.rest.pojo.User;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;

@Service
public class ClientService {

	@Autowired
	GraphQLWebClient graphQLWebClient;

	public Object getUsers() {
		// this.graphQLWebClient=GraphQLWebClient.newInstance(webClient, objectMapper);
		String queryStr = "query{\r\n" + "  getUsers{\r\n" + "    name\r\n" + "    password\r\n" + "    id\r\n"
				+ "    role\r\n" + "  }\r\n" + "}";

		GraphQLRequest request = GraphQLRequest.builder().query(queryStr).build();

		GraphQLResponse graphQLResponse = graphQLWebClient.post(request).block();

		return graphQLResponse.get("getUsers", Object.class);
	}

	public String createStudent(User user) {

		Map<String, Object> variables = new HashMap<>();
		variables.put("user", user);

		String mutationStr = "mutation{\r\n" + "  addUser(user:{\r\n" + "    name:\"n4\"\r\n" + "    role:\"r4\"\r\n"
				+ "    password:\"p4\"\r\n" + "  })\r\n" + "}";

		GraphQLRequest request = GraphQLRequest.builder().query(mutationStr).variables(variables).build();

		graphQLWebClient.post(request).block();

		return HttpStatus.CREATED.toString();
	}
}
