package com.tigerbrokers.stock.openapi.client.util.builder;

import com.tigerbrokers.stock.openapi.client.constant.ReqProtocolType;
import com.tigerbrokers.stock.openapi.client.struct.enums.Subject;
import io.netty.handler.codec.stomp.DefaultStompHeaders;
import io.netty.handler.codec.stomp.StompHeaders;
import java.util.Collection;
import java.util.Set;

/**
 * Description:
 * Created by lijiawen on 2018/05/23.
 */
public class StompHeaderBuilder {

  public static final String REQ_TYPE = ReqProtocolType.REQ_HEADER;
  public static final String FOCUS_KEYS = "keys";
  public static final String VERSION = "1.0";
  public static final String HOST = "localhost";
  public static final String ACCOUNT = "account";
  public static final String SYMBOLS = "symbols";

  private StompHeaders stompHeaders;

  private StompHeaderBuilder() {
    stompHeaders = new DefaultStompHeaders();
  }

  public static StompHeaderBuilder instance() {
    return new StompHeaderBuilder();
  }

  public StompHeaderBuilder version() {
    return version(VERSION);
  }

  public StompHeaderBuilder version(String version) {
    this.stompHeaders.set(StompHeaders.ACCEPT_VERSION, version);
    return this;
  }

  public StompHeaderBuilder host() {
    this.stompHeaders.set(StompHeaders.HOST, HOST);
    return this;
  }

  public StompHeaderBuilder login(String login) {
    this.stompHeaders.set(StompHeaders.LOGIN, login);
    return this;
  }

  public StompHeaderBuilder passcode(String passcode) {
    this.stompHeaders.set(StompHeaders.PASSCODE, passcode);
    return this;
  }

  public StompHeaderBuilder id(int id) {
    this.stompHeaders.set(StompHeaders.ID, String.valueOf(id));
    return this;
  }

  public StompHeaderBuilder reqType(int reqType) {
    this.stompHeaders.set(REQ_TYPE, String.valueOf(reqType));
    return this;
  }

  public StompHeaderBuilder subject(Subject subject) {
    this.stompHeaders.set(StompHeaders.SUBSCRIPTION, subject.name());
    return this;
  }

  public StompHeaderBuilder subject(String subject) {
    this.stompHeaders.set(StompHeaders.SUBSCRIPTION, subject);
    return this;
  }

  public StompHeaderBuilder focusKeys(Set<String> focusKeys) {
    this.stompHeaders.set(FOCUS_KEYS, join(focusKeys));
    return this;
  }

  public StompHeaderBuilder account(String account) {
    this.stompHeaders.set(ACCOUNT, account);
    return this;
  }

  public String join(Collection<String> collection) {
    StringBuilder builder = new StringBuilder();
    boolean isFirst = true;
    for (String symbol : collection) {
      if (!isFirst) {
        builder.append(",").append(symbol);
      } else {
        builder.append(symbol);
        isFirst = false;
      }
    }

    return builder.toString();
  }

  public StompHeaderBuilder symbols(Set<String> symbols) {
    this.stompHeaders.set(SYMBOLS, join(symbols));
    return this;
  }

  public StompHeaders build() {
    return this.stompHeaders;
  }
}
