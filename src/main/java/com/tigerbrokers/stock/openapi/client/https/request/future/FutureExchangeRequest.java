package com.tigerbrokers.stock.openapi.client.https.request.future;

import com.tigerbrokers.stock.openapi.client.constant.ApiServiceType;
import com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants;
import com.tigerbrokers.stock.openapi.client.https.domain.future.model.FutureExchangeModel;
import com.tigerbrokers.stock.openapi.client.https.request.TigerCommonRequest;
import com.tigerbrokers.stock.openapi.client.https.request.TigerRequest;
import com.tigerbrokers.stock.openapi.client.https.response.future.FutureExchangeResponse;

/**
 * Description:
 * Created by lijiawen on 2018/12/18.
 */
public class FutureExchangeRequest extends TigerCommonRequest implements TigerRequest<FutureExchangeResponse> {

  public FutureExchangeRequest() {
    setApiVersion(TigerApiConstants.DEFAULT_VERSION);
    setApiMethodName(ApiServiceType.FUTURE_EXCHANGE);
  }

  public static FutureExchangeRequest newRequest(String secType) {
    return newRequest(secType, null);
  }

  public static FutureExchangeRequest newRequest(String secType, String lang) {
    FutureExchangeRequest request = new FutureExchangeRequest();
    FutureExchangeModel model = new FutureExchangeModel(secType, lang);
    request.setApiModel(model);
    return request;
  }

  @Override
  public Class<FutureExchangeResponse> getResponseClass() {
    return FutureExchangeResponse.class;
  }
}