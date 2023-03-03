package com.bbringworld.ezparkapi.domain.spot.application.provider;

import com.bbringworld.ezparkapi.domain.spot.adaptor.out.SpotInfo;
import com.bbringworld.ezparkapi.domain.spot.dao.entity.Spot;

import java.util.List;

public interface SpotProvider {

    void create(Spot spot);

    void delete(long id);

    void update();

    List<SpotInfo> fetch();

    SpotInfo search(long id);

    SpotInfo update(Spot spot);

}
