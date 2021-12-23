# Queue

## Features
- 가장 먼저 넣은 데이터를 가장 먼저 꺼낼 수 있는 자료 구조
- First In First Out (FIFO) 정책
- Last In Last Out (LILO) 정책
- Linear

## Terminology
- enqueue : 데이터를 넣음
- dequeue : 데이터를 꺼냄
- head : 가장 먼저 들어간 데이터
- tail : 가장 나중에 들어간 데이터

## Pros and Cons
딱히 없음

## Queue in Java
- 정렬된 Object 리스트
- 데이터는 리스트의 마지막에 추가
- 첫 번째 데이터부터 삭제
- PriorityQueue와 LinkedList가 Queue 인터페스를 구현함

## Practice
- 멀티 태스킹을 위한 프로세스 스케줄링

## Extension
- LIFO Queue : Last In, First Out (스택을 안쓰고 왜...)
- Priority Queue : 우선 순위가 높은 것부터 먼저 꺼냄

## References
- [https://www.geeksforgeeks.org/queue-interface-java/](https://www.geeksforgeeks.org/queue-interface-java/)