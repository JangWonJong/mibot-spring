package kr.co.eis.api.voice.services;

import kr.co.eis.api.voice.domains.Voice;
import kr.co.eis.api.voice.repositories.VoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName: kr.co.mibot.api.voice.services
 * fileName   : VoiceServiceImpl
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
@Service
@RequiredArgsConstructor
public class VoiceServiceImpl implements VoiceService{
    private final VoiceRepository repository;

    @Override
    public List<Voice> saveVoiceList(List<Voice> voiceList) {
        return repository.saveAll(voiceList);
    }
}
