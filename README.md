# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


---
## 기능 정의 - step 2 생성
1. 사람 이름을 입력 받음
    - 입력 시 (,) 로 구분 => InputView 활용.
    - 1~5자의 이름. trim 필요. 그 외 에러 처리 => Player 생성 중 확인 [x]
    - 사람 수는 최소 2명 그 외 에러 처리 => Players 객체에서 진행[x]

2. 최대 사다리 높이 입력 받음
    - 최소 1개. 그 외 에러 처리 => Ladder 생성 중 확인 [x]

3. 사다리 생성
    - Player 리스트와 사다리 높이를 매개 변수를 받는 Ladder 객체 생성 [x]
    - 사다리 생성 시 높이 만큼의 Line 객체 생성. [x]
       - 사람 수를 매개 변수로 받고, 각 라인별 가로 줄 여부를 가지고 있음  [x]
       - 가로 줄 여부는 랜덤으로 설정 하되 자신의 왼쪽 라인이 가로줄이 있을 시 무조선 X. [x]
       - Line 객체는 Point 객체를 가져 각 사다리의 가로 라인을 관리함. [x]

4. 사다리 출력
    - Ladder toString으로 사다리 출력 [x]
      - Players toString과 Line toString으로 조합 [x]
    - Player 이름은 출력 시 공백 포함 6칸으로 고정 출력 [x]
    - Line, Point toString 시 ------| 방식으로 출력. 가운데 점은 6개 [x]
    - Ladder 객체를 기반으로 OutputView에서 출력

### 기존 요구사항
#### 기능 요구사항
1. 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
2. 사람 이름은 쉼표(,)를 기준으로 구분한다.
3. 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
4. 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
5. |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

#### 프로그래밍 요구사항
1. 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
2. 규칙 6: 모든 엔티티를 작게 유지한다.


---
## 기능 정의 - step 3 게임 실행
1. 당첨 항목을 최대 사다리 높이전에 입력 받음.
   - Player와 같은 로직 (5자 이내, 출력 시 공백 포함 등...) WinningItem [x]
   - Player 상위 추상 객체 필요(LadderItem) [x]
2. 사다리 결과 출력 시 당첨 항목도 같이 출력
3. 결과를 보고 싶은 사람 입력 받음.
   - Players 객체를 활용하여 입력받은 Player 객체 위치를 찾음 [x]
   - Player 객체의 위치를 기반으로 Line의 결과를 도출 할 수 있는 move 기능 추가 [x]
     - 범위에서 벗어난 index 입력시 에러 처리 [x]
   - 없는 이름 입력 시 Players 에서 에러처리 [x]
   
4. 입력 받은 주체에 따라 결과 출력
   - Player 객체의 위치, Line move 기반으로 최종 위치를 받는 movePlayer, movePlayerAll 기능 추가
   - LadderGame 객체를 활용하여 각 Player move 결과인 PlayerWinnings 리스트 객체를 가지고 있는 LadderGameResults 반환
   - all은 전체 결과 출력
   - 전체 출력 시 프로그램 종료

### 기존 요구사항
#### 기능 요구사항
1. 사다리 실행 결과를 출력해야 한다.
2. 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

#### 프로그래밍 요구사항
1. 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
