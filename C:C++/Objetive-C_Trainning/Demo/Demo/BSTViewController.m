//
//  BSTViewController.m
//  Demo
//
//  Created by William Brown on 12/19/13.
//  Copyright (c) 2013 Brown Sound Technologies. All rights reserved.
//

#import "BSTViewController.h"

@interface BSTViewController ()

@end

@implementation BSTViewController

- (IBAction)changeLable:(id)sender
{
    
    NSString *message = [[NSString aloc] initWithFormat:@"Hello" arguments:[ textField text]];
    
}

- (IBAction)textField:(id)sender {
}



- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
