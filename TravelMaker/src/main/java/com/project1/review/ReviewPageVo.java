package com.project1.review;
public class ReviewPageVo {
  int totSize; //검색된 결과의 전체 건수
  int totPage;
  int startPage;
  int endPage;
  int blockSize=5;
  int nowPage=1;
  int listSize=10;
  int startNo;
  int endNo;
  int  sno;
  String findStr;
  String period;
  String region;
  String city;
  String order; //정렬기준 최신
  boolean chkUserLike;
	public boolean isChkUserLike() {
		return chkUserLike;
	}
	public void setChkUserLike(boolean chkUserLike) {
		this.chkUserLike = chkUserLike;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public ReviewPageVo() {}
  public void pageCompute() {
    // 전체 건수를 사용하여 전체 페이지수 계산
    totPage = (int)Math.ceil(totSize/(double)listSize);
    // 현재 페이지(nowPage)를 사용하여 출력된 게시물의 끝번호와 시작번호 계산
    endNo = nowPage * listSize;
    startNo = endNo-listSize;
    //전체 검색 건수보다 계산된 끝번호가 크면 전체 검색 건수로 값 보정
    if(endNo>totSize) endNo = totSize;
    // 현재 페이지와 블럭사이즈를 사용하여 끝페이지와 시작 페이지 계산
    endPage = (int)Math.ceil(nowPage/(double)blockSize) * blockSize;
    startPage = endPage-blockSize+1;
    // 계산된 끝 페이지가 전체 페이지수 보다 크면 끝페이지 값을 전체 페이지 값으로 보정
    if(endPage>totPage) endPage = totPage;
  }
  public int getTotSize() {return totSize;  }
  public void setTotSize(int totSize) {
    this.totSize = totSize;
    pageCompute();
  }
  public int getTotPage() {return totPage;  }
  public void setTotPage(int totPage) {this.totPage = totPage;  }
  public int getStartPage() {return startPage;  }
  public void setStartPage(int startPage) {this.startPage = startPage;  }
  public int getEndPage() {return endPage;  }
  public void setEndPage(int endPage) {this.endPage = endPage;  }
  public int getBlockSize() {return blockSize;  }
  public void setBlockSize(int blockSize) {this.blockSize = blockSize;  }
  public int getNowPage() {return nowPage;  }
  public void setNowPage(int nowPage) {this.nowPage = nowPage;  }
  public int getListSize() {return listSize;  }
  public void setListSize(int listSize) {this.listSize = listSize;  }
  public int getStartNo() {return startNo;  }
  public void setStartNo(int startNo) {this.startNo = startNo;  }
  public int getEndNo() {return endNo;  }
  public void setEndNo(int endNo) {this.endNo = endNo;  }
  public String getFindStr() {return findStr;  }
  public void setFindStr(String findStr) {this.findStr = findStr;  }
  public int getSno() {return sno;  }
  public void setSno(int sno) {this.sno = sno;  }
  public String getPeriod() {return period;}
	public void setPeriod(String period) {this.period = period;}
	public String getRegion() {return region;}
	public void setRegion(String region) {this.region = region;}
	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}
}