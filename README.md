# 📘 API 명세서
## 🧑‍💼 후보자(Candidate) API
| 메서드    | URL           | 설명        | 요청 예시 (JSON) | 응답 예시         |
| ------ | ------------- | --------- | ------------ | ------------- |
| `GET`  | `/candidates` | 전체 후보자 조회 | -            | 후보자 리스트 반환    |
| `POST` | `/candidates` | 후보자 등록    | ✅ 아래 참고      | 등록된 후보자 정보 반환 |

✅ POST 요청 예시

```
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

✅ GET 응답 예시
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
