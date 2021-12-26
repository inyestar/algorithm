# Tree

## Features
- Node와 Branch를 이용해서 방향성이 있으나 사이클은 없는 자료 구조
- non-linear 자료 구조
- hierarchical connection

## Terminology
- Node : 데이터 저장 기본 단위로 연결된 노드에 대한 정보 포함
- Branch : 노드간의 관계를 보여주는 선
- Root Node : 최상위 노드
- Level : 최상위 노드부터 특정 하위 노드까지의 깊이
- Parent Node : 현재 노드와 연결된 상위 노드
- Child Node : 현재 노드와 연결된 하위 노드
- Leaf Node : Child 노드가 하나도 없는 노드
- Sibling(Brother) Node : 같은 Parent Node를 갖고 있는 노드
- Depth : 트리에서 Node가 갖을 수 있는 최대 Level

## Pros and Cons
#### Pros
- 검색 빠름

#### Cons
- 구현 어려움

## Extension
- Binary Tree : 자식 노드가 최대 2개인 트리
- Binary Search Tree(BST) : 자식 노드의 값이 부모 노드 보다 작으면 왼쪽, 크면 오른 쪽에 위치 해야하는 이진 트리
  - 장점 : 탐색 속도 개선
  - 단점 : 최악의 경우 오른 쪽으로만 자식 노드가 생겨서 O(n)이 될 수 있음 
- Balanced Tree : 모든 leaf node가 같은 레벨이 존재하는 트리
  
## Practice
- 파일 시스템, PDF
- 검색
- XML parser, ML, DNS
- 인덱싱 (B-Tree, B+ tree)
- 소셜 네트워킹, 체스
- 경로 탐색

## References
- [https://www.educative.io/blog/data-structures-trees-java](https://www.educative.io/blog/data-structures-trees-java)