package com.api_financeira_simplificada.service;

import com.api_financeira_simplificada.common.enums.EnumError;
import com.api_financeira_simplificada.domain.transaction.Transaction;
import com.api_financeira_simplificada.domain.user.EnumUserType;
import com.api_financeira_simplificada.domain.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionValidateService {

    @Autowired
    private AuthorizationService authorizationService;

    public void validateTransaction(Transaction transaction) throws Exception {
        User sender = transaction.getSender();

        log.info("Validando tipo do usuário remetente");
        if (sender.getUserType().equals(EnumUserType.MERCHANT)) {
            throw new Exception(EnumError.LOJISTA_NAO_AUTORIZADO.getMessage());
        }

        log.info("Validando saldo do usuário remetente");
        if (sender.getBalance().compareTo(transaction.getValueTransaction()) < 0) {
            throw new Exception(EnumError.SALDO_INDISPONIVEL.getMessage());
        }

    }

    public void validateAuthorizeTransaction() throws Exception {
        log.info("Validando autorização da transação");
        if (!this.authorizationService.authorize().authorization()) {
            throw new Exception(EnumError.TRANSACAO_NAO_AUTORIZADA.getMessage());
        }
    }

}
