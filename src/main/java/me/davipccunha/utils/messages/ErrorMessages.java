package me.davipccunha.utils.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorMessages {
    // General
    NO_PERMISSION("§cVocê não tem permissão para executar esse comando."),
    INVALID_AMOUNT("§cQuantidade inválida."),
    INVALID_ITEM("§cItem inválido."),
    INTERNAL_ERROR("§cOcorreu um erro interno. Por favor, contate nossa equipe."),
    SUBCOMMAND_NOT_FOUND("§cSubcomando não encontrado."),

    // Player
    PLAYER_NOT_FOUND("§cJogador não encontrado."),
    EXECUTOR_NOT_PLAYER("§cApenas jogadores podem executar esse comando."),
    PLAYER_NOT_ONLINE("§cEsse jogador não está online."),

    // Inventory
    INVENTORY_FULL("§cO jogador não tem espaço suficiente no inventário."),

    // Economy
    NOT_ENOUGH_COINS("§cVocê não tem coins suficientes."),
    NOT_ENOUGH_CASH("§cVocê não tem cash suficiente.");

    private final String message;
}
