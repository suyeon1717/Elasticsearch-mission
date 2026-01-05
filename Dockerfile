FROM elasticsearch:9.2.2
RUN bin/elasticsearch-plugin install analysis-nori # 한국어 형태소 분석기 플러그인 설치