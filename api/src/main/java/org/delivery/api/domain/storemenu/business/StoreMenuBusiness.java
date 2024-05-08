package org.delivery.api.domain.storemenu.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.domain.storemenu.controller.model.StoreMenuRegisterRequest;
import org.delivery.api.domain.storemenu.controller.model.StoreMenuResponse;
import org.delivery.api.domain.storemenu.converter.StoreMenuConverter;
import org.delivery.api.domain.storemenu.service.StoreMenuService;

import java.util.List;

@RequiredArgsConstructor
@Business
public class StoreMenuBusiness {

  private final StoreMenuService storeMenuService;
  private final StoreMenuConverter storeMenuConverter;

  public StoreMenuResponse register(
    StoreMenuRegisterRequest request
  ) {
    // req -> entity -> save -> response
    var entity = storeMenuConverter.toEntity(request);
    var newEntity = storeMenuService.register(entity);
    var response = storeMenuConverter.toResponse(newEntity);
    return response;
  }

  public List<StoreMenuResponse> search(
    Long storeId
  ) {
    var list = storeMenuService.getStoreMenuByStoreId(storeId);

    return list.stream()
      .map(storeMenuConverter::toResponse)
      .toList();
  }
}
