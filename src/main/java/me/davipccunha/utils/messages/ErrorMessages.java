package me.davipccunha.utils.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorMessages {
    // General
    NO_PERMISSION("§cVocê não tem permissão para executar esse comando."),
    PLAYER_NOT_FOUND("§cJogador não encontrado."),
    INVALID_AMOUNT("§cQuantidade inválida."),
    INTERNAL_ERROR("§cOcorreu um erro interno. Por favor, contate nossa equipe."),
    EXECUTOR_NOT_PLAYER("§cApenas jogadores podem executar esse comando."),
    SUBCOMMAND_NOT_FOUND("§cSubcomando não encontrado."),
    INVENTORY_FULL("§cO jogador não tem espaço suficiente no inventário."),

    // Economy
    NOT_ENOUGH_COINS("§cVocê não tem coins suficientes.");

    private final String message;
}
