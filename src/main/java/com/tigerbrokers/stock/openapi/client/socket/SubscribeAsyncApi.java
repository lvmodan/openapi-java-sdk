package com.tigerbrokers.stock.openapi.client.socket;

import com.tigerbrokers.stock.openapi.client.struct.enums.Subject;
import java.util.List;
import java.util.Set;

/**
 * Description:
 * Created by lijiawen on 2018/08/29.
 */
public interface SubscribeAsyncApi {

  /**
   * 订阅主题
   *
   * @param subject 主题
   */
  String subscribe(Subject subject);

  /**
   * 订阅主题字段
   *
   * @param subject 主题
   * @param focusKeys 关注key列表
   */
  String subscribe(Subject subject, List<String> focusKeys);

  /**
   * 取消订阅主题
   *
   * @param subject 主题
   */
  String cancelSubscribe(Subject subject);

  /**
   * 订阅行情
   *
   * @param symbols 标的列表
   */
  String subscribeQuote(Set<String> symbols);

  /**
   * 订阅行情字段
   *
   * @param symbols 标的列表
   * @param focusKeys 关注key
   */
  String subscribeQuote(Set<String> symbols, List<String> focusKeys);

  /**
   * 取消订阅行情
   *
   * @param symbols 标的列表
   */
  String cancelSubscribeQuote(Set<String> symbols);

  /**
   * 订阅期权数据
   *
   * @param symbols 标的列表
   */
  String subscribeOption(Set<String> symbols);

  /**
   * 取消订阅期权数据
   *
   * @param symbols 标的列表
   */
  String cancelSubscribeOption(Set<String> symbols);

  /**
   * 订阅期货数据
   *
   * @param symbols 标的列表
   */
  String subscribeFuture(Set<String> symbols);

  /**
   * 取消订单期货数据
   *
   * @param symbols 标的列表
   */
  String cancelSubscribeFuture(Set<String> symbols);

  /**
   * 查询已订阅symbol列表
   */
  String getSubscribedSymbols();
}
