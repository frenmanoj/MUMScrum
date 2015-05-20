package edu.mum.mscrum.hrss.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mscrum.common.service.impl.GenericServiceImpl;
import edu.mum.mscrum.hrss.model.OrganizationChart;
import edu.mum.mscrum.hrss.service.OrganizationChartService;

@Service
@Transactional
public class OrganizationChartServiceImpl extends GenericServiceImpl<OrganizationChart> implements OrganizationChartService {

}
