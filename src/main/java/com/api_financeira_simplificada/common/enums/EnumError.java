package com.api_financeira_simplificada.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumError {

    USUARIO_NAO_ENCONTRADO("Usuário não encontrado"),
    USUARIO_JA_CADASTRADO("Usuário já cadastrado"),
    LOJISTA_NAO_AUTORIZADO("Usuário do tipo Lojista não está autorizado a realizar transferências"),
    SALDO_INDISPONIVEL("Saldo indisponível"),
    TRANSACAO_NAO_AUTORIZADA("Transação não autorizada");

    private String message;
}
