# Stack

## Features
- 한 쪽 끝에서만 데이터를 넣거나 빼는 자료 구조
- First In Last Out (FILO) 정책
- Last In First Out (LIFO) 정책
- Vertical

## Terminology
- push : 데이터를 넣음
- pop : 데이터를 꺼냄

## Pros and Cons
#### Pros
- (일반적으로) 구조가 단순하여 구현이 쉬움
- (일반적으로) 데이터 저장/읽기 속도가 빠름

#### Cons
- (일반적으로) 데이터의 최대 갯수를 미리 지정해서 공간을 확보해야 함
- (일반적으로) 미리 공간을 확보하기 때문에 공간 낭비가 생길 수 있음

## Stack in Java
- Stack은 Vector 클래스를 상속 받고 있어서 synchronized 함
- Stack은 Interface가 아닌 Class
- Thread-safe이 필요한게 아니라면 Interface면서 asynchronous한 Deque 클래스 사용 추천

## Practice
- 프로세스에서 함수 동작 방식

## References
- [https://www.geeksforgeeks.org/stack-class-in-java/](https://www.geeksforgeeks.org/stack-class-in-java/)