<?
if (!defined('_GNUBOARD_')) exit; // 개별 페이지 접근 불가

// 선택옵션으로 인해 셀합치기가 가변적으로 변함
$colspan = 5;

if ($is_checkbox) $colspan++;
if ($is_good) $colspan++; 
if ($is_nogood) $colspan++;
?>
<style>
.board_page { clear:both; text-align:center; margin:3px 0 0 0; }
.board_page a:link { color:#777; }
#loadingDIV{	position:fixed;	z-index:9999;	zoom:1;	width:100%;	display:none;	opacity:0.5;	filter:alpha(opacity:50);	width:100%;	height:100%; }
</style>
<link rel="stylesheet" href="<?=$board_skin_url?>/style.css">

<!-- 김갑열 추가 -->
<div id="loadingDIV" style="height: 5008px; display: none;">
	<img src="<?=$board_skin_url?>/img/ajax-loader.gif" alt="Loading" id="loadingIMG" style="left: 671.5px; top: 333.5px; position: fixed;">
</div>


<table style="width: 100%;">
<tbody>
	<tr>
	<td style="width: 50%;">
		<? if (!$wr_id) {?><h1 id="bo_list_title"><?=$board['bo_subject']?> </h1><?}?>
	</td>
	<td style="width: 50%; text-align: right;">
		<fieldset id="bo_sch" style="text-align: right;"> 
		    <legend>게시물 검색</legend>
		
		    <form name="fsearch" method="get" >
		    <input type="hidden" name="bo_table" value="<?=$bo_table?>">
		    <input type="hidden" name="sca" value="<?=$sca?>">
		    <input type="hidden" name="sop" value="and">
		    <label for="sfl" class="sound_only">검색대상</label>
		    <select name="sfl" id="sfl">
		        <option value="wr_subject"<?=get_selected($sfl, 'wr_subject', true);?>>제목</option>
		        <option value="wr_content"<?=get_selected($sfl, 'wr_content');?>>내용</option>
		        <option value="wr_subject||wr_content"<?=get_selected($sfl, 'wr_subject||wr_content');?>>제목+내용</option>
		        <option value="mb_id,1"<?=get_selected($sfl, 'mb_id,1');?>>회원아이디</option>
		        <option value="mb_id,0"<?=get_selected($sfl, 'mb_id,0');?>>회원아이디(코)</option>
		        <option value="wr_name,1"<?=get_selected($sfl, 'wr_name,1');?>>글쓴이</option>
		        <option value="wr_name,0"<?=get_selected($sfl, 'wr_name,0');?>>글쓴이(코)</option>
		    </select>
		    <label for="stx" class="sound_only">검색어<strong class="sound_only"> 필수</strong></label>
		    <input type="text" name="stx" value="<?=stripslashes($stx)?>" required  class="frm_input required" size="15" maxlength="15">
		    <input type="submit" value="검색" class="btn_submit">
		    </form>
		</fieldset>
	
	</td>
	</tr>
</tbody>
</table>






<!-- 게시판 목록 시작 -->
<div id="bo_list" style="width:<?=$width;?>">

    <? if ($is_category) { ?> 
    <form name="fcategory" id="fcategory" method="get">
    <nav id="bo_cate">
        <h2><?=$board['bo_subject']?> 카테고리</h2>
        <ul id="bo_cate_ul">
            <?=$category_option?>
        </ul> 
    </nav>
    </form> 
    <? } ?>

    <div class="bo_fx">
        <div id="bo_list_total">
            <span>Total <?=number_format($total_count)?>건</span>
           	<!-- 김갑열 추가 -->
            <span id="pagecount"><?=$page?></span> 페이지
        </div>

        <? if ($rss_href || $write_href) {?>
        <ul class="btn_bo_user">
            <? if ($rss_href) { ?><li><a href="<?=$rss_href?>" class="btn_b01">RSS</a></li><? } ?>
            <? if ($admin_href) { ?><li><a href="<?=$admin_href?>" class="btn_admin">관리자</a></li><? } ?>
            <? if ($write_href) { ?><li><a href="<?=$write_href?>" class="btn_b02">글쓰기</a></li><? } ?>
        </ul>
        <? } ?>
    </div>

    <form name="fboardlist" id="fboardlist" action="./board_list_update.php" onsubmit="return fboardlist_submit(this);" method="post">
    <input type="hidden" name="bo_table" value="<?=$bo_table?>">
    <input type="hidden" name="sfl" value="<?=$sfl?>">
    <input type="hidden" name="stx" value="<?=$stx?>">
    <input type="hidden" name="spt" value="<?=$spt?>">
    <input type="hidden" name="page" value="<?=$page?>">
    <input type="hidden" name="sw" value="">

    <table class="basic_tbl">
    <caption><?=$board['bo_subject']?> 목록</caption>
    
    <!-- 김갑열 추가 -->
    <? 
    	$subjetcol = 55; 
    	if ($is_good) $subjetcol-=5;
    	if ($is_nogood) $subjetcol-=5;
    	if ($is_checkbox) $subjetcol-=5;
    ?>
    <colgroup>
	    <col style="width: 10%;"/>
	    <? if ($is_checkbox) { ?><col style="width: 5%;" /><? } ?>
	    <col style="width: <?=$subjetcol?>%;"/>
	    <col style="width: 15%;"/>
	    <col style="width: 10%;"/>
	    <col style="width: 10%;"/>
	    <? if ($is_good) { ?><col style="width: 5%;" /><? } ?>
	    <? if ($is_nogood) { ?><col style="width: 5%;" /><? } ?>
    </colgroup>
    
    <thead>
    <tr>
        <th scope="col">번호</th>
        <? if ($is_checkbox) { ?>
        <th scope="col">
            <label for="chkall" class="sound_only">현재 페이지 게시물 전체</label>
            <input type="checkbox" id="chkall" onclick="if (this.checked) all_checked(true); else all_checked(false);">
        </th>
        <?}?>
        <th scope="col">제목</th>
        <th scope="col">글쓴이</th>
        <th scope="col"><?=subject_sort_link('wr_datetime', $qstr2, 1)?>날짜</a></th>
        <th scope="col"><?=subject_sort_link('wr_hit', $qstr2, 1)?>조회</a></th>
        <? if ($is_good) { ?><th scope="col"><?=subject_sort_link('wr_good', $qstr2, 1)?>추천</a></th><?}?>
        <? if ($is_nogood) { ?><th scope="col"><?=subject_sort_link('wr_nogood', $qstr2, 1)?>비추천</a></th><?}?>
    </tr>
    </thead>
    <tbody>

   	<tr>
   	<td colspan='<?=$colspan?>' style="padding:0;border-top:0px;border-bottom:0;line-height:1.5em;word-break:break-all">  <!-- 김갑열 추가 -->
    <div id="boardlist">  <!-- 김갑열 추가 -->
    
	    <?
	    for ($i=0; $i<count($list); $i++) {
	    	$bg = $i%2 ? 0 : 1; // 김갑열 추가
	    ?>
	    
	    <table class="board_list" id="list<?=$list[$i][wr_id]?>" style="width: 100%; border-collapse:collapse; border-spacing:0" > <!-- 김갑열 추가 -->
		<colgroup>
		    <col style="width: 10%;"/>
		    <? if ($is_checkbox) { ?><col style="width: 5%;" /><? } ?>
		    <col style="width: <?=$subjetcol?>%;"/>
		    <col style="width: 15%;"/>
		    <col style="width: 10%;"/>
		    <col style="width: 10%;"/>
		    <? if ($is_good) { ?><col style="width: 5%;" /><? } ?>
		    <? if ($is_nogood) { ?><col style="width: 5%;" /><? } ?>
    	</colgroup>
    
	    <tbody> <!-- 김갑열 추가 -->

	    <tr class="<? if ($list[$i]['is_notice']) echo "bo_notice";?><? if ($board[1]) echo "bo_sideview";?>">
	        <td class="td_num">
	        <?
	        if ($list[$i]['is_notice']) // 공지사항
	            echo '<strong>공지</strong>';
	        else if ($wr_id == $list[$i]['wr_id'])
	            echo "<span class=\"bo_current\">열람중</span>";
	        else
	            echo $list[$i]['num'];
	        ?>
	        </td>
	        <? if ($is_checkbox) { ?>
	        <td class="td_chk">
	            <label for="chk_wr_id_<?=$i?>" class="sound_only"><?=$list[$i]['wr_subject']?></label>
	            <input type="checkbox" name="chk_wr_id[]" value="<?=$list[$i]['wr_id']?>" id="chk_wr_id_<?=$i?>">
	        </td>
	        <? } ?>
	        <td class="td_subject">
	            <?
	            echo $list[$i]['icon_reply'];
	            if ($is_category && $list[$i]['ca_name']) {
	            ?>
	            <a href="<?=$list[$i]['ca_name_href']?>" class="bo_cate_link"><?=$list[$i]['ca_name']?></a>
	            <? } ?>
	
	            <a href="<?=$list[$i]['href']?>">
	                <?=$list[$i]['subject']?>
	                <? if ($list[$i]['comment_cnt']) { ?><span class="sound_only">댓글</span><?=$list[$i]['comment_cnt'];?><span class="sound_only">개</span><? } ?>
	            </a>
	
	            <?
	            // if ($list[$i]['link']['count']) { echo '['.$list[$i]['link']['count']}.']'; }
	            // if ($list[$i]['file']['count']) { echo '<'.$list[$i]['file']['count'].'>'; }
	
	            if (isset($list[$i]['icon_new'])) echo $list[$i]['icon_new'];
	            if (isset($list[$i]['icon_hot'])) echo $list[$i]['icon_hot'];
	            if (isset($list[$i]['icon_file'])) echo $list[$i]['icon_file'];
	            if (isset($list[$i]['icon_link'])) echo $list[$i]['icon_link'];
	            if (isset($list[$i]['icon_secret'])) echo $list[$i]['icon_secret'];
	
	            ?>
	        </td>
	        <td class="td_name"><?=$list[$i]['name']?></td>
	        <td class="td_date"><?=$list[$i]['datetime2']?></td>
	        <td class="td_num"><?=$list[$i]['wr_hit']?></td>
	        <? if ($is_good) { ?><td class="td_num"><?=$list[$i]['wr_good']?></td><? } ?>
	        <? if ($is_nogood) { ?><td class="td_num"><?=$list[$i]['wr_nogood']?></td><? } ?>
	    </tr>
	    </tbody> <!-- 김갑열 추가 -->
	    </table> <!-- 김갑열 추가 -->
	    <?}?>
    
    </div> <!-- 김갑열 추가 --> 
    
    <? if (count($list) == 0) { echo '<tr><td colspan="'.$colspan.'" class="empty_table">게시물이 없습니다.</td></tr>'; } ?>

    </td></tr>
    </tbody>
    </table>

    <? if ($list_href || $is_checkbox || $write_href) {?>
    <div class="bo_fx">
        <ul class="btn_bo_adm">
            <? if ($list_href) { ?>
            <li><a href="<?=$list_href?>" class="btn_b01"> 목록</a></li>
            <? } ?>
            <? if ($is_checkbox) { ?>
            <li><input type="submit" name="btn_submit" value="선택삭제" onclick="document.pressed=this.value"></li>
            <li><input type="submit" name="btn_submit" value="선택복사" onclick="document.pressed=this.value"></li>
            <li><input type="submit" name="btn_submit" value="선택이동" onclick="document.pressed=this.value"></li>
            <? } ?>
        </ul>

        <ul class="btn_bo_user">
            <? if ($write_href) { ?><li><a href="<?=$write_href?>" class="btn_b02">글쓰기</a></li><? } ?>
        </ul>
    </div>
    <? } ?>
    </form>
</div>

<? if($is_checkbox) { ?>
<noscript>
<p>자바스크립트를 사용하지 않는 경우<br>별도의 확인 절차 없이 바로 선택삭제 처리하므로 주의하시기 바랍니다.</p>
</noscript>
<? } ?>

<!-- 페이지 -->
<? //echo $write_pages; ?>

	<!-- 김갑열 추가 -->
	<div class="board_page">
	<span  onclick="addlist();" style="cursor:hand;"><b>[더보기]</b></span>&nbsp;
	<span  onclick="removelist();" style="cursor:hand;"><b>[줄이기]</b></span>
	</div>



<? if ($is_checkbox) { ?>
<script>
function all_checked(sw) {
    var f = document.fboardlist;

    for (var i=0; i<f.length; i++) {
        if (f.elements[i].name == "chk_wr_id[]")
            f.elements[i].checked = sw;
    }
}

function fboardlist_submit(f) {
    var chk_count = 0;

    for (var i=0; i<f.length; i++) {
        if (f.elements[i].name == "chk_wr_id[]" && f.elements[i].checked)
            chk_count++;
    }

    if (!chk_count) {
        alert(document.pressed + "할 게시물을 하나 이상 선택하세요.");
        return false;
    }

    if(document.pressed == "선택복사") {
        select_copy("copy");
        return;
    }

    if(document.pressed == "선택이동") {
        select_copy("move");
        return;
    }

    if(document.pressed == "선택삭제") {
        if (!confirm("선택한 게시물을 정말 삭제하시겠습니까?\n\n한번 삭제한 자료는 복구할 수 없습니다"))
            return false;
    }

    return true;
}

// 선택한 게시물 복사 및 이동
function select_copy(sw) {
    var f = document.fboardlist;

    if (sw == "copy")
        str = "복사";
    else
        str = "이동";

    var sub_win = window.open("", "move", "left=50, top=50, width=500, height=550, scrollbars=1");

    f.sw.value = sw;
    f.target = "move";
    f.action = "./move.php";
    f.submit();
}
</script>
<? } ?>
<!-- 게시판 목록 끝 -->



<script>
///////////////// 2013.04.21 by 벌이뉨(kkl81@naver.com) //////////////////////
<? 
if($page!=""){
	$QUERY_STRING = str_replace("&page={$page}","",$QUERY_STRING);
}
?>

var p_true = "<?= $page!='1' ? '1':'0' ?>";
var s_page = "<?=$page?>";
var page=eval(s_page)+1;
var lastpage=1000000000;
var s_listrow = "<?=$board[bo_page_rows]?>";
var listrow = eval(s_listrow);
var scroll_true=0;
var donwup=0;
var junpage=1000000000;
var addaction = 0;

var mousescroll = 5; // 마우스 민감도 여기서 조절 하세요

$(document).ready(function(){

	$("#loadingDIV").ajaxStart(function(){
		var $layerPopupObj = $("#loadingIMG");
		var left = (($(window).width() - $layerPopupObj.width()) / 2 );
		var top = (($(window).height() - $layerPopupObj.height()) / 2 );
		$layerPopupObj.css({'left':left,'top':top, 'position':'fixed'});
		$(this).height($(document).height()).fadeIn(100);
	}).ajaxStop(function(){
		$(this).fadeOut(300);
	});

});

function sleep(sec) {
    var now = new Date();
    var exitTime = now.getTime() + (sec*1000);
    while (true) {
          now = new Date();
          if (now.getTime() > exitTime) return;
    }
}


if(p_true==1){
	$("#boardlist").html("");
	//$("#listload").show();
	page--;
	$.post("<?=$board_skin_url?>/list.add.ajax.php?<?=$QUERY_STRING?>&endpage="+page, {}, function(data) {
		data = data.replace(/(^\s*)|(\s*$)/, ''); // 공백제거
		if(data==""){
			page--;
			//$("#listload").hide();
		}else{
			$("#boardlist").html(data);
			page++;
		}
		//$("#listload").hide();
	});	
}

function addlist(){
	
	//$("#listload").show();
	window.scrollTo(0,$(document).height());
	addaction = 1;

	if(lastpage <= page){
		page == lastpage;
		//$("#listload").hide();
		addaction=0;
		return;
	}else{
		$.post("<?=$board_skin_url?>/list.add.ajax.php?<?=$QUERY_STRING?>&page="+page, {}, function(data) {
			data = data.replace(/(^\s*)|(\s*$)/, ''); // 공백제거
			if(data==""){
				lastpage = page;
				//$("#listload").hide();
			}else{
				
				var lastrow = data.split("</table>");
				if(lastpage == page){
					//$("#listload").hide();
					return;
				}
				if(junpage == page){
					//$("#listload").hide();
					return;
				}
				$("#boardlist").html($("#boardlist").html()+data); 
				window.scrollTo(0,$(document).height());
				junpage=page;
				page++;
				if(listrow != (lastrow.length-1)){
					alert("마지막 페이지입니다.");
					lastpage = page;
				}
				//$("#listload").hide();
			}			
			addaction=0;
		});
		
	}
	$("#pagecount").html(page);
}

function removelist(){
	
	window.scrollTo(0,0);
	//$("#listload2").show();
	page--;
	if(page==1){
		alert("더이상 줄일 수 없습니다.");
		//$("#listload2").hide();
		//window.scrollTo(0,$(document).height());
		page++;
		junpage=1000000000;

		$("#pagecount").html(page-1);
		return;
	}
	
	$.post("<?=$board_skin_url?>/list.remove.ajax.php?<?=$QUERY_STRING?>&page="+page, {},function(data) {
		data=data.split("||");
		
		for(var i=0; i < data.length; i++){
			$("#list"+data[i]).remove();
		}
		//$("#listload2").hide();
		junpage=1000000000;
		window.scrollTo(0,$(document).height());
		$("#pagecount").html(page-1);
	});
	
}

/*
// 스크롤 이벤트는 너무 민감해서 사용 포기
$(window).scroll(function(){ 
	if($(window).scrollTop() == $(document).height() - $(window).height()){ 
		$("#listload").show();
		sleep(2);
		addlist();
	}

	if($(window).scrollTop()==0){
		//alert(page);
		//removelist();
	}
});
*/

if(window.addEventListener){
	window.addEventListener('DOMMouseScroll', wheel, false);
}
window.onmousewheel = document.onmousewheel = wheel; 

// 마우스 휠~
function handle(delta) {

	var s = delta + ": ";
	
	donwup+=delta;
	if(addaction==0){
		if (donwup == (mousescroll+1)*-1) {
			if($(window).scrollTop() == 0 && scroll_true == 0){
				addlist();
			}else{
				scroll_true=1;
			}
			donwup=0;
		}
		else if(donwup == (mousescroll+1)) {
			if($(window).scrollTop() == 0){
				removelist();
				scroll_true=0;
			}
			donwup=0;
		}

		else if($(window).scrollTop() == $(document).height() - $(window).height()){ 
			if (donwup == mousescroll*-1) {
				
				addlist();
				donwup=0;
			}
		}
		if(donwup > (mousescroll+1)) donwup=0;
		if(donwup < (mousescroll+1)*-1) donwup=0;
	}
}

//마우스 이벤트 
function wheel(event){
	var delta = 0;
	if (!event) 
		event = window.event;

	if (event.wheelDelta) {
		delta = event.wheelDelta/120;
		if (window.opera) 
			delta = -delta;
	} else if 
		(event.detail) delta = -event.detail/3;

	if (delta) handle(delta);
}

///////////////// 2013.04.21 by 벌이뉨(kkl81@naver.com) //////////////////////
</script>
