//
//  BSTViewController.m
//  SoundCanceling
//
//  Created by William Brown on 12/20/13.
//  Copyright (c) 2013 Brown Sound Technologies. All rights reserved.
//

#import "BSTViewController.h"

@interface BSTViewController ()

@end

@implementation BSTViewController

@synthesize isRunning;
@synthesize button;

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    [button setTitle:@"Start" forState:UIControlStateNormal];
    [button.titleLabel setFont:[UIFont systemFontOfSize: 40]];
    
    isRunning = NO;
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)phaseControl:(id)sender {
}

- (IBAction)startStop:(id)sender
{
    if(!isRunning)
    {
        [button setTitle:@"Stop" forState:UIControlStateNormal];
        isRunning = YES;
        
    }
    else
    {
        [button setTitle:@"Start" forState:UIControlStateNormal];
        isRunning = NO;
    }
    
}

- (IBAction)volumeControl:(id)sender {
}
@end
