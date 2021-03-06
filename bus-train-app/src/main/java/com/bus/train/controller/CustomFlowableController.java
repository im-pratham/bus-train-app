package com.bus.train.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bus.train.model.Fruit;
import com.bus.train.service.FruitService;
import com.google.common.collect.ImmutableMap;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/*
 *  Exercise:
 * 
 *  Create REST endpoints to:
 *  - Get the list of available definitions (keys and names)
 *  - Start a new process by its key
 *  - Get the list of active tasks (task id, process id and task name)
 *  - Complete a specific task by task id
 *  - Get the image representing the current state of a process by process Id
 *  Either use a REST client (like [Postman] to interact with your API or create your own web application client interface)
 * 
 */

@RestController
@RequiredArgsConstructor
public class CustomFlowableController {

    private final RepositoryService repositoryService;
    private final FruitService fruitService;

    @GetMapping("/principal")
    public String principal(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/process-definitions")
    public List<Map<String, String>> getProcessDefinitions(Principal principal) {

        List<ProcessDefinition> processDefinitionList = this.repositoryService.createProcessDefinitionQuery()
                .latestVersion().startableByUser(principal.getName()).list();

        return processDefinitionList.stream().map((pd) -> {
            return ImmutableMap.of("key", pd.getKey(), "name", pd.getName());
        }).collect(Collectors.toList());

    }

    @GetMapping("/fruits")
    public List<Fruit> getFruits() {
        return fruitService.getFruits();
    }

    @GetMapping("fruits/{id}")
    public Fruit getFruit(@PathVariable String id) {
        return fruitService.getFruit(id);
    }

}