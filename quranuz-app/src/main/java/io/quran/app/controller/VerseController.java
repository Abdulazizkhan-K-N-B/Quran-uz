package io.quran.app.controller;

import io.quran.app.config.ApiConfig;
import io.quran.app.payload.verse.VerseBeginEndReq;
import io.quran.app.payload.verse.VerseSurahReq;
import io.quran.app.payload.verse.VersesAfterReq;
import io.quran.app.service.VerseDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Tag(name = "Verse APIs")
@RequestMapping(ApiConfig.VERSE_API)
public class VerseController {
    private final Logger LOG = LoggerFactory.getLogger(VerseController.class);
    private final VerseDetailService verseDetailService;

    public VerseController(VerseDetailService verseDetailService) {
        this.verseDetailService = verseDetailService;
    }

    @GetMapping("/by-surah-lang")
    public ResponseEntity<?> getAllBySurahId(VerseSurahReq verseSurahReq) {

        LOG.info("Rest request to get all verses surahId: {} langId: {}", verseSurahReq.getSurahId(), verseSurahReq.getLangId());
        return ResponseEntity.ok(verseDetailService.getAllBySurahId(verseSurahReq));
    }

    @GetMapping("/begin-end-request")
    public ResponseEntity<?> getAllByJuzRequest(@Valid VerseBeginEndReq verseJuzRequest) {

        LOG.info("Rest request to get all verses by: {}", verseJuzRequest);
        return ResponseEntity.ok(verseDetailService.findAllByJuzRequest(verseJuzRequest));
    }

    @GetMapping("/by-after")
    public ResponseEntity<?> getAllAfter(@Valid VersesAfterReq req) {

        LOG.info("Rest request to get all surah id: {} verses after id: {}", req.getSurahId(), req.getIdAfter());
        return ResponseEntity.ok(verseDetailService.getVersesAfter(req));
    }
}