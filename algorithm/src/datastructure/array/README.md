# Array

## Features
- 유사한 데이터을 저장하기 위한 자료 구조
- 각 데이터를 메모리의 연속적인 위치에 저장
- 인덱스를 사용하여 데이터에 접근

## Pros and Cons
#### Pros
- Random Access : 접근을 원하는 데이터의 인덱스만 알면 빠르게 접근 가능

#### Cons
- Size Limit : 길이가 고정적이기 때문에 배열의 길이를 초과하여 데이터를 추가 할 경우 새로운 배열 할당 필요
- 배열의 중간에 데이터를 추가/삭제 할 경우 각 데이터 위치 조정 필요

## Array in Java
- 동적으로 생성되는 클래스의 Object
- Object를 상속 받으며 Serializable과 Cloneable 인터페이스를 구현함
- C/C++처럼 1차원, 다차원 배열 생성 가능
- C/C++과 다르게 length 멤버 변수를 사용하여 배열의 길이를 구할 수 있음
- C/C++과 다르게 이름이 없는 anonymous arrays 를 지원
  ```java
  ...
  static void print(int[] arr) {
    System.out.println(Arrays.toString(arr));
  }
  
  public static void main(String[] args) {
    print(new int[]{1, 2, 3, 4, 5});
  }
  ...
  ```

## References
- [https://www.javatpoint.com/array-in-java](https://www.javatpoint.com/array-in-java)