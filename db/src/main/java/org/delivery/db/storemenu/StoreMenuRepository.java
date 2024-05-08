package org.delivery.db.storemenu;

import org.delivery.db.storemenu.enums.StoreMenuStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreMenuRepository extends JpaRepository<StoreMenuEntity, Long> {

  // 유효한 메뉴 체크
  Optional<StoreMenuEntity> findFirstByIdAndStatusOrderByIdDesc(Long Id, StoreMenuStatus status);

  // 특정 가게의 메뉴 가져오기
  List<StoreMenuEntity> findAllByStoreIdAndStatusOrderBySequenceDesc(Long StoreId, StoreMenuStatus status);
}
