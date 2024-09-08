package applesquare.moment.util;

import java.util.Random;

public class NicknameGenerator {
    private static final Random random = new Random();
    private static final String[] FIRST_PART={
            "찬란한", "아름다운", "푸른", "그리운", "행복한", "기쁜", "슬픈", "화난", "즐거운", "사랑스러운",
            "귀여운", "멋진", "용감한", "강한", "부드러운", "따뜻한", "차가운", "신비로운", "매력적인", "우아한",
            "고요한", "평화로운", "활기찬", "상냥한", "친절한", "정직한", "성실한", "열정적인", "창의적인", "독립적인",
            "지혜로운", "현명한", "똑똑한", "재미있는", "유쾌한", "명랑한", "쾌활한", "활발한", "적극적인", "긍정적인",
            "낙천적인", "겸손한", "신중한", "조용한", "침착한", "차분한", "단호한", "이질적인", "의심스러운", "믿음직한"
    };
    private static final String[] SECOND_PART = {
            "마카롱", "단팥빵", "초코", "쿠키", "케이크", "푸딩", "젤리", "도넛", "머핀", "크루아상",
            "타르트", "파이", "마들렌", "브라우니", "와플", "팬케이크", "크레이프", "슈크림", "에클레어", "초콜릿",
            "고양이", "강아지", "토끼", "햄스터", "사자", "호랑이", "곰", "여우", "사슴", "코끼리",
            "기린", "판다", "코알라", "캥거루", "돌고래", "참새", "올빼미", "소라", "진주", "종달새",
            "사과", "바나나", "딸기", "포도", "오렌지", "레몬", "라임", "체리", "복숭아", "자두",
            "망고", "파인애플", "키위", "블루베리", "라즈베리", "크랜베리", "석류", "멜론", "수박", "참외",
            "당근", "오이", "토마토", "양파", "감자", "고구마", "브로콜리", "장미", "튤립", "해바라기",
            "데이지", "라일락", "수선화", "백합", "카네이션", "국화", "코스모스", "별", "달", "해",
            "구름", "비", "눈", "바람", "무지개", "안개", "혜성", "행성", "테이블", "쿠션",
            "목걸이", "팔찌", "반지", "귀걸이", "시계", "안경", "선글라스", "모자", "머리띠", "헤어핀"
    };

    public static String generateNickname(){
        String first=FIRST_PART[random.nextInt(FIRST_PART.length)];
        String second=SECOND_PART[random.nextInt(SECOND_PART.length)];
        return first+"_"+second;
    }
}
