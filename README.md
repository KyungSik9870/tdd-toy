#TDD (Test Driven Development)

![tdd](https://user-images.githubusercontent.com/54000031/127758551-2a451705-d201-44c1-87df-73b9f8df967f.png)
[사진 : https://wooaoe.tistory.com/33]

우아한테크캠프 Pro 과정에서 배웠던 TDD 를 복습하고자 합니다.

## ✹ TDD란?
> Test Driven Development. 즉, 테스트가 주도하는 개발.

> 기존에 방식 : 설계 → 개발 → 테스트   
> TDD의 방식 : 설계 → (테스트 - 개발) 위와 같이 3가지의 cycle 을 돌며 개발을 진행하다 테스트를 통하여 설계의 오류를 잡을 수 있음.

### 🔄 TDD 개발 사이클

>  #### 설계 → 실패하는 테스트 케이스 작성(작은 단위) → 테스트 통과하도록 작성 → 리팩토링

> TDD 에서 코드는 크게 두가지로 나눕니다.   
>
> 실제 구현 코드인 *__'프로덕션 코드'__* 와 테스트를 담당하는 *__'테스트 코드'__*  
> 
> TDD 로 개발을 진행하는 경우에는 TDD의 cycle에 맞게 프로덕션 코드 이전에 항상 테스트 코드를 작성합니다.

## 📚 *객체지향 생활 체조 원칙?*
#### 필요한 이유❓

>TDD 를 왜 하는지에 대하여 고민을 해보면, 객체지향 생활 체조 원칙 뿐만 아니라 이펙티브 자바, 클린코드와 같은 책을 읽을 수 밖에 없게 되는 것 같습니다.  
>
>그 이유를 생각해보면, TDD 를 함으로써 설계의 오류를 잡아가며 도메인 설계를 하게 되고,
>테스트 코드를 작성함에 있어 작은 단위로 기능을 쪼개게 됩니다. (작은 단위의 테스트가 더 쉽고 단위테스트에 용이)
> 
>그러면 자연스럽게 메서드가 분리되고, 객체지향적인 설계 능력을 필요로 하게 되는데  
>이때 클린한 코드를 만들 수 있어야 한다고 생각합니다.
> 
>따라서 객체지향 생활 체조 원칙, 이펙티브 자바, 클린코드 등 코드의 품질을 높일 수 있는 추가적인 공부가 필수라고 생각합니다.
> 
>클린한 코드를 만들 수 없고, 객체지향적인 사고를 할 수 없다면 설계에도 어려움이 있을거고 이것은 테스트코드의 작성을 어렵게 할 것입니다.    
>그렇다면 자연스레 TDD 와 멀어지고 이전의 개발습관으로 돌아갈 것 입니다.  


#### 📔 *출처 : 소트웍스 앤솔러지* 
 *1. 한 메서드에 오직 한 단계의 들여 쓰기만 한다.*  
 *2. else 예약어를 쓰지 않는다.*  
 *3. 모든 원시 값과 문자열을 포장한다.*   
 *4. 한 줄에 점을 하나만 찍는다.*  
 *5. 줄여 쓰지 않는다 (축약 금지).*  
 *6. 모든 엔티티를 작게 유지한다.*  
 *7. 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.*    
 *8. 일급 컬렉션을 쓴다.*   
 *9. getter/setter/프로퍼티를 쓰지 않는다.*  

> *__객체에 메시지를 보내라 ( 객체에 역할을 잘 위임해라 )__*

---
# 💻  요구사항
>쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우,    
구분자를 기준으로 분리한 각 숫자의 합을 반환  
조건 - null 이거나 빈 값이면 0을 리턴한다


위의 요구사항으로 TDD 연습을 해보려고 한다.  
가장 먼저 해야할 것은 요구사항을 보고, 작은 단위의 기능으로 쪼개보는 것이다.  

1. null 이거나 빈 값이면 0을 리턴.  
2. 숫자 하나만 input 으로 전달받았을 경우, 그대로 리턴한다.  
3. 쉼표를 구분자로 문자열을 잘라 각 자리를 더해서 리턴한다.  
4. 쉼표 또는 콜론을 구분자로 문자열을 잘라 각 자리를 더해서 리턴한다.   

이렇게 기능을 작게 만들고, TDD 의 사이클에 맞게 개발을 시작하겠습니다.  
기능을 작게 만드는 이유는 테스트 코드를 짜기 용이하기 위해서이다.  
작은 단위로 작성해야 단위테스트에 용이하고, TDD 를 하기 좋습니다.

---

✨ 이후의 과정은 커밋을 통해 순서를 보여주고자 합니다.

---

*커밋의 순서를 보면 중간에 리팩토링 과정을 생략한 것도 있지만, 전체적으로 TDD의 사이클을 지키면서 코딩하였다.*  
*이렇게 했을 때 장점은 특히 리팩토링 과정에서 많이 느껴졌다.*  

*리팩토링을 할 때 기존의 기능은 제대로 동작하는지 테스트로 검증이 가능하니*  
*코드를 틀리게 고칠 일이 없었다.*

*기능을 쪼개어 단위 테스트를 만들고, 메서드를 분리하니 후에 유지보수에도 강점을 갖는 코드를 만들게 된 것 같아*  
*간단한 예제이지만 TDD로 얻을 수 있는 장점들을 경험할 수 있었다*












