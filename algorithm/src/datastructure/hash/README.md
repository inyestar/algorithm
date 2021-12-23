# Hash Table

## Features
- Key와 Value의 일대일 매칭
- Key를 통해 데이터 접근이 가능한 자료 구조
- Key의 hash가 같을 경우 충돌이 일어나는데 이를 해결하기 위해 Chaining 기법이나 Linear Probing 기법을 사용

## Terminology
- hash : 임의 값을 고정 길이로 변환 하는 것
- hasing function : key에 대한 산술 연산을 통해 데이터 위치를 찾는 함수 
- slot : 한 개의 데이터를 저장하는 공간

## Pros and Cons
#### Pros
- Key를 통해 바로 데이터의 위치를 알 수 있으므로 데이터 참조 속도가 빠름

#### Cons
- 공간이 커질 수록 충돌이 적어지기 때문에 충분한 공간을 확보하려다보니 공간이 많이 필요함
- 충돌이 많이 발생하면 최악의 경우 O(n)이 될수도 있음

## HashMap in Java
- 데이터를 key와 value 한 쌍으로 저장 할 수 있는 Map 인터페이스 구현체
- HashTable과 다르게 비동기
- key는 유일해야 함
- null 값도 저장 가능하며 null key(1개)도 가능
- 순서를 유지하지 않음

## References
- [https://www.javatpoint.com/java-hashmap#:~:text=HashMap%20in%20Java%20is%20like,and%20implements%20the%20Map%20interface.](https://www.javatpoint.com/java-hashmap#:~:text=HashMap%20in%20Java%20is%20like,and%20implements%20the%20Map%20interface.)