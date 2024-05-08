package org.delivery.api.domain.store.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.delivery.api.common.api.Api;
import org.delivery.api.domain.store.business.StoreBusiness;
import org.delivery.api.domain.store.controller.model.StoreRegisterRequest;
import org.delivery.api.domain.store.controller.model.StoreResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/store")
public class StoreOpenApiController {

  private final StoreBusiness storeBusiness;

  @PostMapping("/register")
  public Api<StoreResponse> register(
    @Valid
    @RequestBody Api<StoreRegisterRequest> request
  ) {
    var response = storeBusiness.register(request.getBody());
    return Api.OK(response);
  }
}
