package com.cjc.hl.main.servicei;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.cjc.hl.main.entity.SancationLetter;

public interface SanctionLetterservicei
{

	public  ByteArrayInputStream getSanctionLetter(SancationLetter s);

	public List<SancationLetter> getSanLetter();

}
