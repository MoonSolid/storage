<? 
	sleep(1);
	$subjetcol = 55;
	if ($is_good) $subjetcol-=5;
	if ($is_nogood) $subjetcol-=5;
	if ($is_checkbox) $subjetcol-=5;

	    for ($i=0; $i<count($list); $i++) {

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