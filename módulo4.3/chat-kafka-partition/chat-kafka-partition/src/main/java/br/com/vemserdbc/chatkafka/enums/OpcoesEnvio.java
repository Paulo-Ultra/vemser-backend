package br.com.vemserdbc.chatkafka.enums;

import java.util.Arrays;

public enum OpcoesEnvio {

    GERAL("chat-geral"),
    BRUNO("chat-bruno"),
    CASTRO("chat-castro"),
    CESAR("chat-cesar"),
    DAYVIDSON("chat-dayvidson"),
    GABRIEL("chat-gabriel"),
    JEAN("chat-jean"),
    MACHADO("chat-machado"),
    CLEBER("chat-cleber"),
    CLEBSON("chat-clebson"),
    PAULO("chat-paulo"),
    RAFAEL("chat-rafael"),
    RODRIGO("chat-rodrigo"),
    WILLIAN("chat-willian");



    private String chat;

    OpcoesEnvio(String chat){
        this.chat = chat;
    }

    public String getChat(){return chat;}

    public static OpcoesEnvio ofTipo(String chat){
        return Arrays.stream(OpcoesEnvio.values())
                .filter(tp -> tp.getChat().equals(chat))
                .findFirst()
                .get();
    }

}