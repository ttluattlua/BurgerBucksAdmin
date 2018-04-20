// Dashboard 1 Morris-chart
$( function () {
	"use strict";


	// Extra chart
	Morris.Area( {
		element: 'extra-area-chart',
		data: [ {
				period: '2001',
				고객수: 100,
				매출: 0,
				주문량: 90,
				지점수: 0
        }, {
				period: '2002',
				고객수: 10,
				매출: 60,
				주문량: 40,
				지점수: 80

        }, {
				period: '2003',
				고객수: 120,
				매출: 10,
				주문량: 90,
				지점수: 30
        }, {
				period: '2004',
				고객수: 0,
				매출: 0,
				주문량: 120,
				지점수: 0
        }, {
        		고객수: '2005',
        		매출: 0,
        		주문량: 0,
        		지점수: 0
        }, {
				period: '2006',
				고객수: 160,
				매출: 75,
				주문량: 30,
				지점수: 60
        }, {
				period: '2007',
				고객수: 10,
				매출: 120,
				주문량: 40,
				지점수: 60
        }


        ],
		lineColors: [ '#26DAD2', '#fc6180', '#62d1f3', '#ffb64d'],
		xkey: 'period',
		ykeys: [ '고객수', '매출', '주문량', '지점수' ],
		labels: [ '고객수', '매출', '주문량', '지점수'],
		pointSize: 0,
		lineWidth: 0,
		resize: true,
		fillOpacity: 0.8,
		behaveLikeLine: true,
		gridLineColor: '#e0e0e0',
		hideHover: 'auto'

	} );



} );
