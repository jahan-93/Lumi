from dotenv import load_dotenv
load_dotenv()

from lumi.lumi_brain import create_lumi_chain
from lumi.profile import create_profile_from_answers

print("안녕! 나는 루미야 너를 완벽하게 이해하기 위해 5가지만 물어볼게!\n")

# 1. 아침형 vs 저녁형
print("1. 너는 아침형 인간이야, 저녁형 인간이야?")
print("   0: 아침형 (아침에 에너지 터져요)")
print("   1: 저녁형 (밤에 진짜 살아나요)")
chronotype_choice = int(input("→ "))

# 2. 집중력
print("\n2. 평소 집중을 잘 하는 편이야?")
print("   0: 잘 함 (방해 좀 받아도 괜찮아)")
print("   1: 보통 (조용해야 좀 됨)")
print("   2: 잘 못 함 (쉽게 딴짓함)")
focus_level = int(input("→ "))

# 3. 최대 집중 시간
print("\n3. 한 번 앉았을 때 최대 몇 분 정도 집중할 수 있어?")
print("   0: 25분 이하")
print("   1: 50분 정도")
print("   2: 90분 정도")
print("   3: 2시간 이상")
max_focus_idx = int(input("→ "))

# 4. 취침 시간
print("\n4. 보통 몇 시에 자? (24시간 기준)")
print("   예: 밤 11시 → 23 / 새벽 1시 → 1 / 새벽 3시 → 3")
sleep_hour = int(input("→ "))

# 5. 기상 시간
print("\n5. 보통 몇 시에 일어나?")
print("   예: 아침 6시 → 6 / 아침 8시 → 8 / 11시 → 11")
wake_hour = int(input("→ "))

# 프로필 생성
profile = create_profile_from_answers(
    chronotype_choice, focus_level, max_focus_idx, sleep_hour, wake_hour
)

print("\n" + "="*60)
print("루미가 너를 완벽하게 이해했어!")
print(profile)
print("="*60 + "\n")

# 사용자 입력
fixed = input("오늘 고정 일정 알려줘 (없으면 엔터):\n→ ")
todo = input("\n오늘 꼭 하고 싶은 일 3~5개 (우선순위 순으로):\n→ ")

print("\n\n잠깐만~ 루미가 열심히 일정 짜는 중...\n")
chain = create_lumi_chain()
result = chain.invoke({
    "profile": profile,
    "fixed_schedule": fixed if fixed.strip() else "고정 일정 없음",
    "todo_list": todo
})

print("\n" + "="*70)
print("루미가 짜준 오늘 하루 일정이야~!")
print(result)
print("="*70)
print("오늘도 루미랑 함께 화이팅! 너라면 무조건 할 수 있어")