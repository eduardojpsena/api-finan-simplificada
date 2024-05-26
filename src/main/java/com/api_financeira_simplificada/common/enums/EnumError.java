package com.api_financeira_simplificada.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumError {

    USUARIO_NAO_ENCONTRADO("Usuário não encontrado"),
    LOJISTA_NAO_AUTORIZADO("Usuário do tipo Lojista não está autorizado a realizar transferências"),
    SALDO_INDISPONIVEL("Saldo indisponível");

    private String message;
}
