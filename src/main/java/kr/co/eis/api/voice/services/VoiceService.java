package kr.co.eis.api.voice.services;

import kr.co.eis.api.voice.domains.Voice;

import java.util.List;

/**
 * packageName: kr.co.mibot.api.voice.services
 * fileName   : VoiceService
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
public interface VoiceService {
    List<Voice> saveVoiceList(List<Voice> voiceList);
}
