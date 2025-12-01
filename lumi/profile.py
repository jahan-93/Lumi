def create_profile_from_answers(
    chronotype_choice: int,    # 0=아침형, 1=저녁형
    focus_level: int,          # 0=잘함, 1=보통, 2=어려움
    max_focus_idx: int,        # 0=25분, 1=50분, 2=90분, 3=2시간+
    sleep_hour: int,           # 취침 시간 (0~23)
    wake_hour: int             # 기상 시간 (0~23)
) -> str:

    # 1. 사용자가 직접 선택한 아침형/저녁형 (최우선 반영!)
    chronotype = "극강 종달새형(아침형)" if chronotype_choice == 0 else "극강 올빼미형(저녁형)"

    # 2. 집중력 수준
    focus_texts = ["집중력 최고", "보통 집중", "집중 어려움"]
    focus = focus_texts[focus_level]

    # 3. 최대 집중 시간 & 추천 블록
    focus_times = ["25분 이하", "50분 정도", "90분 정도", "2시간 이상"]
    blocks = [
        "25분 작업 + 5분 휴식 (뽀모도로 필수)",
        "50분 작업 + 10분 휴식",
        "90분 작업 + 15~20분 휴식",
        "2시간 이상 딥워크 가능"
    ]
    max_time = focus_times[max_focus_idx]
    block = blocks[max_focus_idx]

    # 4. 수면 시간 계산
    sleep_duration = (wake_hour + 24 - sleep_hour) % 24
    if sleep_duration < 6:
        sleep_quality = "수면 부족 주의! 오늘은 가볍게 가자"
    elif sleep_duration > 9:
        sleep_quality = "수면 충분하지만 과수면 조심"
    else:
        sleep_quality = "적정 수면, 최고의 컨디션!"

    return f"""
- 생체 리듬: {chronotype}
- 사용자가 선택한 타입: {'아침형' if chronotype_choice == 0 else '저녁형'}
- 평균 기상 시간: {wake_hour:02d}:00 전후
- 평균 취침 시간: {sleep_hour:02d}:00 전후
- 실제 수면 시간: 약 {sleep_duration}시간 ({sleep_quality})
- 집중력 수준: {focus}
- 최대 집중 가능 시간: {max_time}
- 추천 작업 방식: {block}
- 오늘 컨디션: 보통 (실제 수면에 따라 조정됨)
""".strip()