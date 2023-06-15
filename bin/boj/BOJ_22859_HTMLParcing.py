import re
html = input()

pattern = r'<div title="(.*?)">(.*?)<\/div>'
matches = re.findall(pattern, html, re.DOTALL)

for match in matches:
    title = match[0]
    inner_pattern = r'<p>(.*?)<\/p>'
    inner_matches = re.findall(inner_pattern, match[1])
    print(f"title : {title}")
    for inner_match in inner_matches:
        res = re.sub(r'<.*?>', '', inner_match)  # 태그 삭제
        res = re.sub(r'\s{2,}', ' ', res)  # 연속 공백 처리
        res = res.strip()  # 양끝 공백 처리
        print(res)
