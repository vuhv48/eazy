package com.eazybytes.message2.function;

import com.eazybytes.message2.dto.AccountMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;


@Configuration
public class MessageFunctions {
    private static Logger logger = LoggerFactory.getLogger(MessageFunctions.class);

//    http://localhost:9010/email
    @Bean
    public Function<AccountMsgDto, AccountMsgDto> email(){
        return accountMsgDto -> {
            logger.info("Sending email with the details" + accountMsgDto.toString());
            return accountMsgDto;
        };
    }

    @Bean
    public Function<AccountMsgDto, Long> sms(){
        return accountMsgDto -> {
            logger.info("Sending sms with the details" + accountMsgDto.toString());
            return accountMsgDto.accountNumber();
        };
    }
}
