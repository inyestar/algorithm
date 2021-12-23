# List

## Features
- linear 자료 구조
- 메모리에 순차적으로 저장되는 것이 아닌 여기저기 분산되어 저장
- 공간을 미리 확보하지 않고 필요 시 저장
- 각 데이터, 즉 노드 끼리의 연결성을 나타내는 포인터를 가지고 있음

## Terminology
- Node : 데이터 저장 단위로 값과 포인터로 구성 됨
- Pointer : 각 노드의 이전 노드 혹은 다음 노드의 주소

## Pros and Cons
#### Pros
- 데이터 삭제와 추가가 빠름

#### Cons
- 데이터 접근 시 전체 노드에 접근해야 함

## List in Java
- java.util 패키지의 Collection 프레임워크 중 하나
- 중복된 값을 가질 수 있음
- Node는 추가된 순서데로 저장되므로 순서를 유지함(ordered)
- 비동기(non thread-safe)

## Extension
- Doubly Linked List : 다음(next) 노드에 대한 포인터 외에도 이전(prev) 노드에 대한 포인터도 갖고 있음

## References
- [https://www.javatpoint.com/java-linkedlist](https://www.javatpoint.com/java-linkedlist)