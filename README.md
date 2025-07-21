# 📘 API 명세서

## 🧑‍💼 후보자(Candidate) API

| 메서드    | URL           | 설명             | 요청 예시 (JSON) | 응답 예시             |
|----------|---------------|------------------|------------------|------------------------|
| `GET`    | `/candidates` | 전체 후보자 조회 | -                | 후보자 리스트 반환     |
| `POST`   | `/candidates` | 후보자 등록       | ✅ 아래 참고       | 등록된 후보자 정보 반환 |

### ✅ POST 요청 예시
```json
{
  "name": "홍길동",
  "gender": "M",
  "birthDate": "1980-03-15",
  "profileImageUrl": "http://example.com/hong.jpg",
  "party": {
    "id": 1
  }
}
```
### ✅ GET 응답 예시
```json
[
  {
    "id": 1,
    "name": "홍길동",
    "birthDate": "1980-03-15",
    "gender": "M",
    "profileImageUrl": "http://example.com/hong.jpg",
    "createdAt": "2025-06-17T12:34:56",
    "party": {
      "id": 1,
      "name": "진보당",
      "logoUrl": "http://example.com/progressive.png",
      "description": "서민을 위한 정당입니다."
    }
  }
]
```
---

## 🏛️ 정당(Party) API

| 메서드    | URL        | 설명       | 요청 예시 (JSON) | 응답 예시        |
| ------ | ---------- | -------- | ------------ | ------------ |
| `GET`  | `/parties` | 전체 정당 조회 | -            | 정당 리스트 반환    |
| `POST` | `/parties` | 정당 등록    | ✅ 아래 참고      | 등록된 정당 정보 반환 |

### ✅ POST 요청 예시
```json
{
    "name": "진보당",
    "logoUrl": "http://example.com/progressive.png",
    "description": "서민을 위한 정당입니다."
}
```

### ✅ GET 응답 예시
```json
[
    {
        "id": 1,
        "name": "진보당",
        "logoUrl": "http://example.com/progressive.png",
        "description": "서민을 위한 정당입니다."
    },
    {
        "id": 2,
        "name": "보수당",
        "logoUrl": "http://example.com/conservative.png",
        "description": "전통을 중시하는 정당입니다."
    }
]
```

---

## 🎯 공약(Pledge) API
| 메서드    | URL                            | 설명            | 요청 예시 (JSON) | 응답 예시        |
| ------ | ------------------------------ | ------------- | ------------ | ------------ |
| `GET`  | `/api/candidates/{id}/pledges` | 특정 후보자의 공약 조회 | -            | 공약 리스트 반환    |
| `POST` | `/api/candidates/{id}/pledges` | 특정 후보자의 공약 등록 | ✅ 아래 참고      | 등록된 공약 정보 반환 |

### ✅ POST 요청 예시
```json
{
    "title": "기초 생활 보장 확대",
    "description": "전 국민 기초 소득 제공을 위한 법안 추진",
    "category": "복지"
}
```

### ✅ GET 응답 예시
```json
{
    "id": 1,
    "title": "기초 생활 보장 확대",
    "description": "전 국민 기초 소득 제공을 위한 법안 추진",
    "category": "복지",
    "createdAt": "2025-06-18T14:32:10.123"
}
```

---

## 🚨 전과(Criminal Record) API
| 메서드    | URL                                     | 설명           | 요청 예시 (JSON) | 응답 예시        |
| ------ | --------------------------------------- | ------------ | ------------ | ------------ |
| `GET`  | `/api/candidates/{id}/criminal-records` | 후보자 전과 기록 조회 | -            | 전과 기록 리스트 반환 |
| `POST` | `/api/candidates/{id}/criminal-records` | 후보자 전과 기록 등록 | ✅ 아래 참고      | 등록된 전과 기록 반환 |

### ✅ POST 요청 예시
```json
{
    "caseDetail": "공직선거법 위반",
    "sentence": "징역 6개월, 집행유예 2년",
    "judgmentDate": "2019-05-21"
}
```
### ✅ GET 응답 예시
```json
[
  {
    "id": 1,
    "caseDetail": "공직선거법 위반",
    "sentence": "징역 6개월, 집행유예 2년",
    "judgmentDate": "2019-05-21"
  }
]
```

---

## 🎓 학력(Education) API

| 메서드    | URL                               | 설명        | 요청 예시 (JSON) | 응답 예시        |
| ------ | --------------------------------- | --------- | ------------ | ------------ |
| `GET`  | `/api/candidates/{id}/educations` | 후보자 학력 조회 | -            | 학력 리스트 반환    |
| `POST` | `/api/candidates/{id}/educations` | 후보자 학력 등록 | ✅ 아래 참고      | 등록된 학력 정보 반환 |

### ✅ POST 요청 예시
```json
{
  "schoolName": "서울대학교",
  "major": "컴퓨터공학",
  "degree": "학사",
  "graduationYear": 2020
}
```
### ✅ GET 응답 예시
```json
[
  {
    "id": 1,
    "schoolName": "서울대학교",
    "major": "컴퓨터공학",
    "degree": "학사",
    "graduationYear": 2020
  },
  {
    "id": 2,
    "schoolName": "MIT",
    "major": "AI Engineering",
    "degree": "석사",
    "graduationYear": 2024
  }
]
```
---

## 💼 경력(Career) API
| 메서드    | URL                            | 설명        | 요청 예시 (JSON) | 응답 예시        |
| ------ | ------------------------------ | --------- | ------------ | ------------ |
| `GET`  | `/api/candidates/{id}/careers` | 후보자 경력 조회 | -            | 경력 리스트 반환    |
| `POST` | `/api/candidates/{id}/careers` | 후보자 경력 등록 | ✅ 아래 참고      | 등록된 경력 정보 반환 |

### ✅ POST 요청 예시
```json
{
  "position": "기획팀장",
  "organization": "더불어민주당 중앙당",
  "startDate": "2018-03-01",
  "endDate": "2022-02-28"
}
```

### ✅ GET 응답 예시
```json
[
  {
    "id": 1,
    "position": "기획팀장",
    "organization": "더불어민주당 중앙당",
    "startDate": "2018-03-01",
    "endDate": "2022-02-28"
  }
]
```

---

## 🎥 토론 영상(Debate Video) API
| 메서드    | URL                                  | 설명           | 요청 예시 (JSON) | 응답 예시        |
| ------ | ------------------------------------ | ------------ | ------------ | ------------ |
| `GET`  | `/api/candidates/{id}/debate-videos` | 후보자 토론 영상 조회 | -            | 토론 영상 리스트 반환 |
| `POST` | `/api/candidates/{id}/debate-videos` | 후보자 토론 영상 등록 | ✅ 아래 참고      | 등록된 토론 영상 반환 |

### ✅ POST 요청 예시
```json
{
  "title": "2024년 정책 토론회",
  "videoUrl": "https://youtube.com/watch?v=example123",
  "broadcastDate": "2024-04-10"
}
```
### ✅ GET 응답 예시
```json
[
  {
    "id": 1,
    "title": "2024년 정책 토론회",
    "videoUrl": "https://youtube.com/watch?v=example123",
    "broadcastDate": "2024-04-10"
  }
]
```