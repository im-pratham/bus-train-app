package com.bus.train.service;

import java.util.Map;

import com.flowable.action.api.bot.BaseBotActionResult;
import com.flowable.action.api.bot.BotActionResult;
import com.flowable.action.api.bot.BotService;
import com.flowable.action.api.history.HistoricActionInstance;
import com.flowable.action.api.repository.ActionDefinition;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class LogHelloBotService implements BotService {

    @Override
    public String getKey() {
        return "log-hello-action";
    }

    @Override
    public String getName() {
        return "Log Hello Action";
    }

    @Override
    public String getDescription() {
        return "Action to log hello.";
    }

    @Override
    public BotActionResult invokeBot(HistoricActionInstance actionInstance, ActionDefinition actionDefinition,
            Map<String, Object> payload) {
        log.info("Hello!");

        return new BaseBotActionResult();
    }

    
}