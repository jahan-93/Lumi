import os
from dotenv import load_dotenv
from langchain_openai import ChatOpenAI
from langchain_core.output_parsers import StrOutputParser
from langchain_core.prompts import ChatPromptTemplate, SystemMessagePromptTemplate, HumanMessagePromptTemplate
from .prompt_template import LUMI_SYSTEM_PROMPT

load_dotenv()

def create_lumi_chain():
    llm = ChatOpenAI(
        model="llama-3.3-70b-versatile",           # 2025년 12월 기준 최고 성능 + 초고속
        base_url="https://api.groq.com/openai/v1",
        api_key=os.getenv("GROQ_API_KEY"),
        temperature=0.7,
        max_tokens=3000,
    )

    prompt = ChatPromptTemplate.from_messages([
        SystemMessagePromptTemplate.from_template(LUMI_SYSTEM_PROMPT),
        HumanMessagePromptTemplate.from_template(
"""사용자 프로필:
{profile}

고정 일정:
{fixed_schedule}

오늘 꼭 하고 싶은 일 (우선순위 순):
{todo_list}

위 정보를 바탕으로 오늘 하루 일정을 만들어줘!
루미답게 따뜻하고 현실적으로 부탁해~"""
        )
    ])

    chain = prompt | llm | StrOutputParser()
    return chain