package io.quran.app.service;

import io.quran.app.payload.api.ApiResult;
import io.quran.app.payload.juz.JuzDto;
import io.quran.db.entity.Juz;
import java.util.Collection;

public interface JuzService {
    void saveJuz(Juz juz);

    ApiResult<Collection<JuzDto>> getAllJuz(Integer languageId);
}
